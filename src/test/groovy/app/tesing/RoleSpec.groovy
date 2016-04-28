package app.tesing

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Role)
class RoleSpec extends Specification {

    void 'test if mapping generator assigned allows constructor initialization'() {
        when:
        def role = new Role(id: 'foobar')

        then:
        'foobar' == role.id
    }

    void 'test if mapping generator assigned allows post-constructor initialization'() {
        when:
        def role = new Role()
        role.id = 'foobar'

        then:
        'foobar' == role.id
    }
}

