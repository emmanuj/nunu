package nunu
//represents a status update
class Teta {
	
	String message //represents a message
	
	static belongsTo =[user:User] // the user that created this post
	
	Date dateCreated
    static constraints = {
		message blank:false, nullable:false, size:5..200 //message size is between 5 and 200 and cannot be empty
		user nullable:false, blank:false //every tweet must have a user
    }
	
	static mapping = {
		autoTimestamp true //sets dateCreatde as time status was created
		order 'desc'
		sort 'dateCreated'
	}
	
	
}
