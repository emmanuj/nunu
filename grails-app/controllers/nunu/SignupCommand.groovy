
package nunu

@grails.validation.Validateable
class SignupCommand{
	String username
	String email
	String password
	String confirm_password
	
    static constraints = {
		email email:true, blank:false, nullable:false, unique:true
		username blank:false, nullable:false, unique:true
		
		password blank:false, nullable:false, size:6..9, validator:{ val, obj ->
			return val == obj.confirm_password
		}
    }
	
}