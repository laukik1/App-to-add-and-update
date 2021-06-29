<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="../css/mystyle.css" rel="stylesheet" type="text/css"/>
        <style>
            
        </style>

    </head>
    <body>
        
        <main class="d-flex align-items-center primary-background-cl banner-background" style="padding-bottom:5px;">
            <div class="container">
                <div class="row">
                    <div id="add-form" class="col-md-6 offset-md-3">
                        <div class="card">
                        
                        
                            <div class="card-header primary-background text-white text-center">
                                <span class="fa fa-user-plus fa-3x"></span>
                                <br>
                                <p>Register here</p>
                            </div>
                            
                            <div class="card-body">
                                <sf:form novalidate="return validate()" id="reg-form" 
                                action="do_register"  method="POST" modelAttribute="customer">
<!--                                <div class="mb-3">
                                  <label for="exampleInputEmail1" class="form-label ">User Name</label>
                                  <input type="text" class="form-control" aria-describedby="emailHelp">
                                  
                                </div>-->
                                <%-- <div>
						          <label for="email">Email : </label>
						          <sf:input path="email" />
						        </div> --%>
                                    <div class="mb-3">
                                        <label for="exampleInputtext1" class="form-label">User Name</label>
                                        <sf:input path="name" type="text" class="form-control name-field" placeholder=" Enter name" aria-label="Username" />
                                        <small class="form-field-msg form-text text-danger ml-2"></small>
                                        <sf:errors path="name" cssClass="error" />
                                    </div>
									
                                <div class="mb-3">
                                  <label for="exampleInputEmail1" class="form-label">Email address</label>
                                  <sf:input path="email" type="email" class="form-control email-field" placeholder=" Enter email" id="exampleInputEmail1" aria-describedby="emailHelp" />
                                  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                                  <small class="email-field-msg form-text text-danger ml-2"></small>
                                  <sf:errors path="email" cssClass="error" />
                                </div>

                                <div class="mb-3">
                                  <label for="exampleInputPassword1" class="form-label">Password</label>
                                  <sf:password path="password" class="form-control password-field" placeholder=" Password" id="exampleInputPassword1" />
                                  <small class="password-field-msg form-text text-danger ml-2"></small>
                                </div>

                                    <label for="gender">Select Gender</label>
                                    <div class="form-check">
                                        <!-- <input class="form-check-input" value="male" /> -->
                                        <sf:radiobutton path="gender" value="Male" id="flexRadioDefault1" />
                                       <!--  <label class="form-check-label" for="flexRadioDefault1"> -->
                                          Male
                                        
                                    </div>
                                      <div class="form-check">
                                          <!-- <input class="form-check-input" value="female" /> -->
                                          <sf:radiobutton path="gender" value="Female" id="flexRadioDefault2" />
                                        <!-- <label class="form-check-label" for="flexRadioDefault2"> -->
                                          Female
                                        
                                      </div>
                                    
                                    <div class="form-group">
                                        <sf:textarea path="description" class="form-control" rows="5" placeholder="Write about yourself.."></sf:textarea>
                                    </div>
                                    
                                <div class="mb-3 form-check">
                                    <sf:checkbox path="checkbox" class="form-check-input" id="exampleCheck1" />
                                  <label class="form-check-label" for="exampleCheck1">Agree terms & conditions</label>
                                  <sf:errors path="checkbox" cssClass="error" />
                                </div>
                                    <br>
                                    <div class="container text-center" id="loader" style="display : none;">
                                        <span class="fa fa-refresh fa-spin fa-3x"></span>
                                        <h4>Please wait....</h4>
                                    </div>
                                        
                                     <a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
                                    <sf:button id="submit-btn" type="submit" class="btn btn-primary">Submit</sf:button>
                              </sf:form>
                            </div>
                        </div>
                            
                    
                    
                </div>
            </div>
        </main>
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="../js/myjs.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        
        <script>
            $(document).ready(function(){
                
                let editStatus=false;
                $('#update-btn').click(function(){
//                    alert("button clicked")
                    if(editStatus == false)
                    {
                    $("#add-form").hide()
                    
                    $("#edit-form").show();
                    
                    editStatus =true;
                    
                    $(this).text("Back")
                    
                    }else
                    {
                        $("#add-form").show()
                    
                        $("#edit-form").hide();
                        
                        editStatus =false;
                        
                        $(this).text("Edit")
                    }
                })
            });
        </script>
 
    </body>
</html>
