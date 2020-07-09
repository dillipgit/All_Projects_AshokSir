<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<!-- CSS only -->
 <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	
<script src="https://code.jquery.com/jquery-3.5.1.js"></script> 


<script type="text/javascript">
	$(document).ready(function() {
		$('#contact').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function confirmDelete() {
		return confirm("Are yuo sure ..You want to delete");
	}
</script>

</head>



<body>

	<form:form action="/save" modelAttribute="contact" method="POST">
	
		<div class="container p-3 mb-2 bg-light text-dark">
			<h2>Save Contacts</h2>
			
			<h3 style="color: blue;">${successMsg}</h3>
			<h3 style="color: red;">${errosMessage}</h3>
			
			
			<div class="row">
				<div class="col-4">
					<label for="name">Usre Name</label>
				</div>
				<div class="col-4">
					<form:input type="hidden" path="contactId" />
					<form:input type="text" path="contactName" id="name"  name="name"/>
				</div>
				<!--Step 1 -->
				<div class="col-4" >
				<span id="nameError"></span>
				</div>
				
			</div>
			
			
			<div class="row">
				<div class="col-4">
					<label for="email">User Email</label>
				</div>
				<div class="col-4">
					<form:input type="text" path="contactEmail" name="email" id="email" />
				</div>
				
				<div class="col-4">
							<span id="userMailError"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="con">Contact Number</label>
				</div>
				<div class="col-4">
					<form:input type="text" path="contactNumber" name="con" id="con" />
				</div>
				<div class="col-4">
				<span id="userContactError"></span>
				</div>
			</div>


			<div class="row">
				<div class="col-4">
					<form:button value="reset" class="btn btn-warning">Reset</form:button>
				</div>
				<div class="col-4">

					<form:button value="submit" class="btn btn-success" id="register">Insert</form:button>
				</div>
			</div>



			<a href="/all">All Contacts List</a>
		</div>
		
	</form:form>
	
	<script type="text/javascript">
    $(document).ready(function(){
        
        $("#nameError").hide();
        $("#userMailError").hide();
        $("#userContactError").hide();
        
        var nameError = false;
        var userMailError = false;
        var userContactError = false;
        
        $("#name").keyup(function(){
            validateName();
            });

        $("#email").keyup(function(){
            validateEmail();
            });

        $("#contact").keyup(function(){
        	validateContact();
            });




        function validateContact(){
    	    var val= $("#con").val();
    	    var exp = /^(\+91)?[6-9][0-9]{9}$/;
    	    
    		if(val==''){
    		   $("#userContactError").show();
    		   $("#userContactError").html("Enter <b>User Contact</b>");
    		   $("#userContactError").css("color","red");
    		   userContactError = false;
    		}else if(!exp.test(val)){
    		   $("#userContactError").show();
    		   $("#userContactError").html("Invaild <b>User Contact</b>");
    		   $("#userContactError").css("color","red");
    		   userContactError = false;
    		}else{
    		   $("#userContactError").hide();
    		   userContactError = true;
    		}
    	     return userContactError;
    	  }

        
        function validateName(){
        	 
    	    var val = $("#name").val();
    		if(val==''){
    		  $("#nameError").show();
    		  $("#nameError").html("Name <b>Must Requeird </b>");
    	  	  $("#nameError").css("color","red");
    	  	nameError = false;
    		}else{
    	      $("#nameError").hide();
    	      nameError = true;
    		}
    		return nameError;
    	  }


        function validateEmail(){
   	     var val=$("#email").val();
   	     var exp=/^[a-zA-Z0-9-_]+\@[a-zA-Z]{2,8}\.[a-z]{2,6}$/;
   		 if(val==''){
   		   $("#userMailError").show();
   	       $("#userMailError").html("Enter <b> User Mail</b>");
   		   $("#userMailError").css("color","red");
   		   userMailError = false;
   		 }else if(!exp.test(val)){
   		   $("#userMailError").show();
   	       $("#userMailError").html("Not a Valid <b> User Mail</b>");
   		   $("#userMailError").css("color","red");
   		   userMailError = false;
   		 
   		 }else{
   	  	   $("#userMailError").hide();
   		    userMailError = true;

   	         
   		 }
   	     return userMailError;
   	  }


       
         	  



        $("#register").click(function(){
            
        	nameError = false;
        	userMailError = false;
        	userContactError = false;
			

        	validateName();
        	validateEmail();
        	validateContact();
	       

			if( validateName() && validateEmail() && validateContact())
			  return true;
	        else 
			  return false;

		});
	    
        
        });
			  
	</script>
	
	
	   <div class="container">
		<!-- class="container" -->
		
		 <c:choose>
		
	<c:when test="${!empty allContacts}"> 
		<a href="/">+Add Contact</a>
		 <h2>Contacts List</h2>
		<table class="table table-border table-hover" id="contact" cellspacing="0">
			<!--  class="table table-border table-hover" -->
			<thead>
			<tr class="table-primary">
				<!--  class="table-primary -->
				<th>S.NO</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>ACTIONS</th>
			</tr>
          </thead>
          <tbody>
			<c:forEach items="${allContacts}" var="obj" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${obj.contactName}</td>
					<td>${obj.contactEmail}</td>
					<td>${obj.contactNumber}</td>
					<td>
					<a href="delete?cid=${obj.contactId}"class="btn btn-danger" onClick="return confirmDelete()">DELETE</a>
					 <a href="edit?cid=${obj.contactId}" class="btn btn-info">EDIT</a>
					 </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		 </c:when> 
		 <c:otherwise>
	<h4></h4>
	</c:otherwise> 
		 </c:choose>  
	</div> 
	
	
</body>


</html>





