package grakn.doc.test.query;


import grakn.client.GraknClient;
import graql.lang.Graql;
import graql.lang.query.GraqlQuery;
import graql.lang.query.GraqlCompute;
import graql.lang.query.GraqlDefine;
import graql.lang.query.GraqlUndefine;
import graql.lang.query.GraqlMatch;
import graql.lang.query.GraqlDelete;
import graql.lang.query.GraqlInsert;
import graql.lang.query.GraqlUpdate;
import graql.lang.query.GraqlCompute.Argument;
import graql.lang.pattern.Pattern;
import graql.lang.common.GraqlArg;
import grakn.client.concept.answer.ConceptMap;
import grakn.client.concept.answer.ConceptMapGroup;
import grakn.client.concept.answer.Numeric;
import grakn.client.concept.answer.NumericGroup;
import org.junit.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static graql.lang.common.GraqlArg.Algorithm.*;
import static graql.lang.common.GraqlArg.Order.*;
import static graql.lang.query.GraqlCompute.Argument.*;
import static graql.lang.query.GraqlCompute.Argument.*;
import static graql.lang.Graql.*;

public class GraqlJavaTest {
    static GraknClient client;
    static GraknSession session;
    GraknTransaction transaction;

    private void runQuery(GraqlQuery query) {
        List<ConceptMap> conceptMaps;
        Numeric num;
        try {
            if (query instanceof GraqlMatch) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                conceptMaps = transaction.query().match(query.asMatch()).collect(Collectors.toList());
            } else if (query instanceof GraqlMatch.Aggregate) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                transaction.query().match(query.asMatchAggregate()).get();
            } else if (query instanceof GraqlMatch.Group) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                List<ConceptMapGroup> x = transaction.query().match(query.asMatchGroup()).collect(Collectors.toList());
            } else if (query instanceof GraqlMatch.Aggregate) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.READ);
                num = transaction.query().match(query.asMatchAggregate()).get();
            } else if (query instanceof GraqlMatch.Group.Aggregate) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                List<NumericGroup> x = transaction.query().match(query.asMatchGroupAggregate()).collect(Collectors.toList());

            } else if (query instanceof GraqlDefine) {
                session = client.session("social_network", GraknSession.Type.SCHEMA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                transaction.query().define(query.asDefine()).get();

            } else if (query instanceof GraqlUndefine) {
                session = client.session("social_network", GraknSession.Type.SCHEMA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                transaction.query().undefine(query.asUndefine()).get();

            } else if (query instanceof GraqlInsert) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                conceptMaps = transaction.query().insert(query.asInsert()).collect(Collectors.toList());

            } else if (query instanceof GraqlDelete) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                transaction.query().delete(query.asDelete()).get();
            } else if (query instanceof GraqlUpdate) {
                session = client.session("social_network", GraknSession.Type.DATA);
                transaction = session.transaction(GraknTransaction.Type.WRITE);
                conceptMaps = transaction.query().update(query.asUpdate()).collect(Collectors.toList());


            } else if (query instanceof GraqlCompute) {
                // FIXME(vmax): we dunno how to run them yet
            } else {
                throw new RuntimeException("Unknown query type: " + query.toString() + "[type = " + query.getClass() + "]");
            }
        } finally {
            if (transaction != null) {
                transaction.close();
            }
            if (session != null) {
                session.close();
            }
        }
    }


    @BeforeClass
    public static void loadSocialNetwork() throws Exception {
        String address = "localhost:1729";

        client = Grakn.coreClient(address);
        client.databases().create("social_network");
        session = client.session("social_network", GraknSession.Type.SCHEMA);
        GraknTransaction transaction = session.transaction(GraknTransaction.Type.WRITE);

        try {
            byte[] encoded = Files.readAllBytes(Paths.get("files/social-network/schema.gql"));
            String query = new String(encoded, StandardCharsets.UTF_8);
            transaction.query().define(Graql.parseQuery(query)).get();

            encoded = Files.readAllBytes(Paths.get("files/phone-calls/schema.gql"));
            query = new String(encoded, StandardCharsets.UTF_8);
            transaction.query().define(Graql.parseQuery(query)).get();

            encoded = Files.readAllBytes(Paths.get("files/negation/schema.gql"));
            query = new String(encoded, StandardCharsets.UTF_8);
            transaction.query().define(Graql.parseQuery(query)).get();

            transaction.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        session.close();
    }

    @AfterClass
    public static void closeSession() throws Exception {
        client.databases().get("social_network").delete();
    }

    // TEST METHODS PLACEHOLDER
}
