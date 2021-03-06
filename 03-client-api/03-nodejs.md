---
pageTitle: Client Node.js
keywords: grakn, client, node.js
longTailKeywords: grakn node.js client, grakn client node.js, client node.js, python node.js
Summary: API Reference of Grakn Client Node.js.
---

## Installation

#### To use this client, you need a compatible Grakn Server running. Visit our [Compatibility Table](#dependencies)


```
npm install grakn-client
```

## Quickstart
First make sure that the [Grakn server](/docs/running-grakn/install-and-run#start-the-grakn-server) is running.

In your source, require `grakn-client/Grakn`.

<!-- test-example socialNetworkNodejsClientA.js -->
```javascript
const { Grakn } = require("grakn-client/Grakn");
```

Instantiate a client and open a session.

<!-- test-example socialNetworkNodejsClientB.js -->
```javascript
const { Grakn } = require("grakn-client/Grakn");
const { SessionType } = require("grakn-client/api/GraknSession");

async function openSession (database) {
	const client = Grakn.coreClient("localhost:1729");
	const session = await client.session(database, SessionType.DATA);
	// session is open
	await session.close();
	//session is closed
	client.close();
};

openSession("social_network");
```

Create transactions to use for reading and writing data.

<!-- test-example socialNetworkNodejsClientC.js -->
```javascript
const { Grakn } = require("grakn-client/Grakn");
const { SessionType } = require("grakn-client/api/GraknSession");
const { TransactionType } = require("grakn-client/api/GraknTransaction");

async function createTransactions (database) {
	const client = Grakn.coreClient("localhost:1729");
	const session = await client.session(database, SessionType.DATA);

	// creating a write transaction
	const writeTransaction = await session.transaction(TransactionType.WRITE); // write transaction is open
	// to persist changes, write transaction must always be committed/closed
	await writeTransaction.commit();

	// creating a read transaction
	const readTransaction = await session.transaction(TransactionType.READ); // read transaction is open
	// read transaction must always be closed
	await readTransaction.close();
	// a session must always be closed
	await session.close();
	// a client must always be closed
	client.close();
}

createTransactions("social_network");
```

Running basic retrieval and insertion queries.

<!-- test-example socialNetworkNodejsClientD.js -->
```javascript
const { Grakn } = require("grakn-client/Grakn");
const { SessionType } = require("grakn-client/api/GraknSession");
const { TransactionType } = require("grakn-client/api/GraknTransaction");

async function runBasicQueries(database) {
	const client = Grakn.coreClient("localhost:1729");
	const session = await client.session(database, SessionType.DATA);

	// Insert a person using a WRITE transaction
	const writeTransaction = await session.transaction(TransactionType.WRITE);
	const insertStream = await writeTransaction.query().insert('insert $x isa person, has email "x@email.com";');
	const conceptMaps = await insertStream.collect();
	console.log("Inserted a person with ID: " + conceptMaps[0].get("x").getIID());
	// to persist changes, a write transaction must always be committed (closed)
	await writeTransaction.commit();

	// Retrieve persons using a READ only transaction
	const readTransaction = await session.transaction(TransactionType.READ);

	// We can either query and consume the iterator lazily
	let answerStream = await readTransaction.query().match("match $x isa person; get $x; limit 10;");
	for await (const aConceptMapAnswer of answerStream) {
		const person = aConceptMapAnswer.get("x");
		console.log("Retrieved person with id " + person.getIID());
	}

	// Or query and consume the iterator immediately collecting all the results
	answerStream = await readTransaction.query().match("match $x isa person; get $x; limit 10;");
	const persons = await answerStream.collect()
	persons.forEach( conceptMap => {
        person = conceptMap.get("x");
        console.log("Retrieved person with id "+ person.getIID());
    });

	// a read transaction must always be closed
	await readTransaction.close();
	// a session must always be closed
	await session.close();
	// a client must always be closed
	client.close();
}

runBasicQueries("social_network");
```

<div class="note">
[Important]
Remember that transactions always need to be closed. Committing a write transaction closes it. A read transaction, however, must be explicitly closed by calling the `close()` method on it.
</div>

Check out the [Concept API](../04-concept-api/00-overview.md) to learn about the available methods on the concepts retrieved as the answers to Graql queries.

To view examples of running various Graql queries using the Grakn Client Node.js, head over to their dedicated documentation pages as listed below:
- [Insert](../11-query/03-insert-query.md)
- [Get](../11-query/02-get-query.md)
- [Delete](../11-query/04-delete-query.md)
- [Update](../11-query/05-update-query.md)
- [Aggregate](../11-query/06-aggregate-query.md)

## API Reference

{% include api/generic.html data=site.data.03_client_api.references.grakn language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.client language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.session language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.options language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.transaction language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.query_manager language="javascript" %}

{% include api/answers.html data=site.data.03_client_api.references.answer language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.query_future language="javascript" %}

{% include api/generic.html data=site.data.03_client_api.references.stream language="javascript" %}


## Version Compatibility

| Client Node.js | Grakn Core                  | Grakn Cluster  |  Node     |
| :------------: | :-------------------------: | :------------: | :-------: |
| 2.0.1          | 2.0.2                       | 2.0.2          | \>= 14.15 |
| 2.0.0          | 2.0.0, 2.0.1                | 2.0.0, 2.0.1   | \>= 14.15 |
| 1.8.0          | 1.8.0 to 1.8.4              | N/A            | \>= 6.5   |
| 1.7.0          | 1.7.1, 1.7.2                | N/A            | \>= 6.5   |
| 1.6.0          | 1.6.0 to 1.6.2              | 1.6.2          | \>= 6.5   |
| 1.5.6          | 1.5.8, 1.5.9                | 1.5.8          | \>= 6.5   |
| 1.5.5          | 1.5.8, 1.5.9                | 1.5.8          | \>= 6.5   |
| 1.5.3          | 1.5.2 to 1.5.7              | 1.5.2 to 1.5.7 | \>= 6.5   |
| 1.5.1          | 1.5.0, 1.5.1                | N/A            | \>= 6.5   |
| 1.2.4 to 1.3.1 | 1.3.0, 1.4.0, 1.4.2, 1.4.3  | 1.2.0          | \>= 6.5   |
| 1.2.0 to 1.2.2 | 1.2.0                       | 1.2.0          | \>= 6.5   |

