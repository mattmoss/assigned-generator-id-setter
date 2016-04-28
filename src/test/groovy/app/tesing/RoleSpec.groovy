package app.tesing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Role)
class RoleSpec extends Specification {

    @Unroll
    void 'test if mapping generator assigned allows constructor initialization'() {
        when:
        def role = new Role(id: name, name: name)

        then:
        name == role.name
        name == role.id

        where:
        name << ['foobar', '42', 'superduper']
    }

    @Unroll
    void 'test if mapping generator assigned allows post-constructor initialization'() {
        when:
        def role = new Role(name: name)
        role.id = name

        then:
        name == role.name
        name == role.id

        where:
        name << ['foobar', '42', 'superduper']
    }
}

