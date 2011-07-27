package myfirstapp

import grails.converters.JSON

class FooController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [fooInstanceList: Foo.list(params), fooInstanceTotal: Foo.count()]
    }

    def requestParams = {
		render text: params
    }

    def jsonList = {
       render Foo.list() as JSON
    }

    def create = {
        def fooInstance = new Foo()
        fooInstance.properties = params
        return [fooInstance: fooInstance]
    }

    def save = {
        def fooInstance = new Foo(params)
        if (fooInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'foo.label', default: 'Foo'), fooInstance.id])}"
            redirect(action: "show", id: fooInstance.id)
        }
        else {
            render(view: "create", model: [fooInstance: fooInstance])
        }
    }

    def show = {
        def fooInstance = Foo.get(params.id)
        if (!fooInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'foo.label', default: 'Foo'), params.id])}"
            redirect(action: "list")
        }
        else {
            [fooInstance: fooInstance]
        }
    }

    def edit = {
        def fooInstance = Foo.get(params.id)
        if (!fooInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'foo.label', default: 'Foo'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [fooInstance: fooInstance]
        }
    }

    def update = {
        def fooInstance = Foo.get(params.id)
        if (fooInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (fooInstance.version > version) {
                    
                    fooInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'foo.label', default: 'Foo')] as Object[], "Another user has updated this Foo while you were editing")
                    render(view: "edit", model: [fooInstance: fooInstance])
                    return
                }
            }
            fooInstance.properties = params
            if (!fooInstance.hasErrors() && fooInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'foo.label', default: 'Foo'), fooInstance.id])}"
                redirect(action: "show", id: fooInstance.id)
            }
            else {
                render(view: "edit", model: [fooInstance: fooInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'foo.label', default: 'Foo'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def fooInstance = Foo.get(params.id)
        if (fooInstance) {
            try {
                fooInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'foo.label', default: 'Foo'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'foo.label', default: 'Foo'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'foo.label', default: 'Foo'), params.id])}"
            redirect(action: "list")
        }
    }
}
