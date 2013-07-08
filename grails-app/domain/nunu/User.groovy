package nunu

class User {
	String email //represents users email
	String username// represents username of user
	String password  // user password
	String confirm_password
	Date dateCreated
	//model relationships
	static hasMany =[following:User, tetas:Teta]//list of user followers, users followed and user's tetas(messages/tweets)
	
    static constraints = {
		email email:true, blank:false, nullable:false, unique:true
		username blank:false, nullable:false, unique:true
		password blank:false, nullable:false, size:6..9
		following blank:true, nullable:true // it is possible not to be following anybody
		tetas nullable:true, blank:true // it is possible to have no tweets
    }

	//database mappings
	static mapping = {
		autoTimestamp true // sets dateCreated as time user was created
	}
}


