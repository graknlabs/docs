---
sidebarTitle: Overview
pageTitle: Concept API
permalink: /docs/concept-api/overview
toc: false
---

## Concept Architecture
Anything in Grakn, whether a type or an instance of data, is a [Concept](/docs/concept-api/concept). The diagram below, illustrates how the Concept Superclass is inherited by its direct and indirect descendants.

![Concept Hierarchy](/docs/images/concept-api/overview_hierarchy.png)

**Type** refers to a Concept Type as defined in the [schema](/docs/schema/overview#data-model).

**Thing** refers to an instance of data that is an instantiation of a Concept Type.

**Rule** refers to a [Graql Rule](/docs/schema/rules).

<div class="note">
[Important]
The methods called on Concepts are bound to the [transaction](/docs/client-api/overview#transaction) that was used to retrieve the concept initially. As soon as the transaction in question is closed, methods can no longer be called on the retrieved Concepts. To do so, we must retrieve the Concept again with a newly created transaction.
</div>

In the sections that follow, we learn about the methods available on [Concept](/docs/concept-api/concept), [Type](/docs/concept-api/type#type-methods), [EntityType](/docs/concept-api/type#entitytype-methods), [AttributeType](/docs/concept-api/type#attributetype-methods), [RelationType](/docs/concept-api/type#relationtype-methods), [Thing](/docs/concept-api/thing#thing-methods), [Attribute](/docs/concept-api/thing#attribute-methods), [Relation](/docs/concept-api/thing#relation-methods) and [Rule](/docs/concept-api/rule).
