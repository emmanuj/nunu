package nunu

class UserController {

    def index() {
		//show user profile here
	}
	
	def register(SignupCommand cmd){
		
		if(request.get){
			return
		}
		
		
		if(cmd.validate()){
			def user = new User(params)
			user.save(flush:true)
			
			session.user = user
			redirect controller:'home', action:'index'
		}else{
			render view:'register', model:[user:cmd]
		}	
	}
	
	def login(){
		
		if(request.get){
			return
		}
		
		def user_id = params.user_id
		def password = params.password
		
		def query = User.where{
			("username"==user_id || "email"== user_id && "password" == password )
		}
		
		def foundUser = query.find()
		
		if(foundUser){
			session.user = foundUser
			redirect controller:"home", action:"index"
		}else{
			render view:"login",model:[user:foundUser]
		}
		
	}
	def logout(){
		session.user = null
		session.invalidate()
		
		redirect url:""
	}
	
}
