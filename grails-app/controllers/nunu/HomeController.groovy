package nunu

class HomeController {

    def index() {
	
		if(!session.user){
			return
		}
		
		def tetas = loadUserTimeline()
		
		[tetas:tetas, followers:getFollowers(), currentuser:session.user]
	}
	def getFollowers(){
		def currentuser = session.user
		//println currentuser.username
		if(!currentuser){
			return null
		}
		
		//def followers = User.findAllByFollowingAndInList(	currentuser)	
		def followers = User.list()
		return followers
		
	}
	def loadUserTimeline(){
		def currentuser = session.user
		
		if(!currentuser)
			return null
			
		def query = Teta.whereAny{
			"user" == currentuser
			"user" in currentuser.following
		}.order 'dateCreated', 'desc'
		
		def updates = query.list()
		
		return updates
	}
	def showUsers(){
	
	}
	
	def followUser(user){
		def currentuser = session.user.attach()
		
		currentuser.addToFollowing(user)
		
		render "followed"
	}
	def postTeta(){
		if(!session.user){
			return;
		}
		def teta = new Teta(message:params.message, user:session.user)
		try{
			teta.save(flush:true)
		}catch(e){
			//println e.message
		}
		def tetas = loadUserTimeline()

		render template:'tetas', collection:tetas, var:'teta'
	}
	def profile(){
		//show profile
	}
}
