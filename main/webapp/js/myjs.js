function validate(){
	
	let f = false;
	
	let name = $(".name-field").val();
	
	if(name == "" || name == undefined)
	{
		$('.form-field-msg').html('Name is required').addClass('text-danger');
	}else
	{
		$('.form-field-msg').removeClass('text-danger');
		f=true;
	}
	
	let email = $(".email-field").val();
	let exp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	
	if(email == "" || email == undefined)
	{
		$('.email-field-msg').html('email is required').addClass('text-danger');
		
	}else if(exp.test(email) == false)
	{
		$('.email-field-msg').html('email must be in correct format i.e (example@email.com)').addClass('text-danger');
	}
	else
	{
		$('.email-field-msg').removeClass('text-danger');
		f=true;
	}
	
	let password = $(".password-field").val();
	
	let exp1 = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	
	if(password == "" || password == undefined)
	{
		$('.password-field-msg').html('password is required').addClass('text-danger');
		
	}else if(exp1.test(password) == false)
	{
		$('.password-field-msg').html('password must be in correct format i.e 1 uppercase, 1 lowercase, 1 digit &  length must be more than 6 character').addClass('text-danger');
	}
	else
	{
		$('.password-field-msg').removeClass('text-danger');
		f=true;
	}
	
	return f;
}

/*
            $(document).ready(function(){
                console.log("loaded...")
                
                $('#reg-form').on('submit',function(event){
                    event.preventDefault();
                    
                    let form=new FormData(this);
                    
                    $('#submit-btn').hide();
                    $('#loader').show();
                    //send data to register servelet
                    $.ajax({
                       // url: "RegisterServlet",
                        type: 'POST',
                        data: form,
                        success: function(data, textStatus, jqXHR){
                            console.log(data)
                             $('#submit-btn').show();
                             $('#loader').hide();
                             
                             if(data.trim()==='done')
                             {
                             swal({
                                    title: "Good job!",
                                    text: "Registered Successfully!",
                                    icon: "success",
                                    button: "We are redirecting to login page !",
                                })
                                        .then((value) => {
                                        window.location = "login_page.jsp"
                                    });
                                  
                              }else
                                {
                                    swal(data);
                                }
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                            console.log(jqXHR)
                            $('#submit-btn').show();
                             $('#loader').hide();
                             swal({
                                    title: "Error !",
                                    text: "Something went wrong.. try again!",
                                    icon: "warning",
                                    button: "Aww yiss!",
                                  });
                        },
                        processData : false,
                        contentType : false
                    })
                    
                });
                
    });
*/