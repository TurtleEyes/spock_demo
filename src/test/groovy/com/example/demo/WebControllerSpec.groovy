package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.Collectors

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class WebControllerSpec extends Specification{
    @Autowired
    TestRestTemplate restTemplate;

    def "Basic integer works" (){
        expect:
        restTemplate.getForEntity("/api/entity/3",String.class).body == "3"
    }

    @Unroll
    def "#b is returned when #a is passed" (){
        expect:
        Integer.valueOf(restTemplate.getForEntity("/api/entity/"+a,String.class).body) == b

        where:
        a | b
        1 | 1
        2 | 2
        3 | 3
        4 | 4
        5 | 5
        6 | 6
        7 | 7
    }

    @Unroll
    def "counter is #d is returned when #a is passed" (){
        given:
        def abc = restTemplate.getForEntity("/api/math/"+a+"/"+b,MathResponse.class).body

        expect:
        abc.value == c && abc.operationCount == d

        where:
        [a, b, c, d] << [[1,1,2,1],[2,2,4,2],[3,3,6,3]]//.combinations()
    }

    def "all people returned" (){
        given:
        def names = ['Nick','Caityln','Santosh','Sandeep']

        when:
        def people = restTemplate.getForEntity("/api/people",ArrayList<Person>)
                .body.stream().map(x -> x.name).collect(Collectors.toList())

        then:
        people.containsAll(names)

    }
}
