from("telegram:bots/{{telegram-token}}")
    .choice()
        .when()
            .simple('${in.body} != null')
            .to("direct:response1")

from("direct:response1")
    .log('Incoming message from Telegram is ${in.body}')
        .choice()
        .when(simple('${bodyAs(java.lang.String)} contains "#camelkrocks"'))
        .setBody(simple('Did somebody say #camelrocks? Of course it does!'))
        .to("telegram:bots/{{telegram-token}}")
                .end()