
# id initialization in constructor when generator is assigned

This test is related to the following, closed bug reports:

[GRAILS-1984](https://github.com/grails/grails-core/issues/2667)
[GRAILS-8422](https://github.com/grails/grails-core/issues/2691)

If the mapping block for a domain class specifies the `id` field to be `generator: 'assigned'`,
the `id` field can be assigned post-construction, but not during construction by way of the map
argument to the constructor.

That is, with a domain class:

    class DomainClass {
        String id
        static mapping = {
            id generator:'assigned'
        }
    }

This works:

    def obj = new DomainClass()
    obj.id = '42'

But this does not:

    def obj = new DomainClass(id: '42')

Both issues linked above contain comments implying this has been fixed for Grails 2.2-RC1 and 2.2-RC3,
but I have encountered the issue in versions 2.2.5 and 3.1.5.

