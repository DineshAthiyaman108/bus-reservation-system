let userName = document.getElementById('userName');
let userEmail = document.getElementById('userEmail');
let userPassword = document.getElementById('userPassword');
let userNumber = document.getElementById('userNumber');
let form = document.getElementById('form');
let userAddhar = document.getElementById('userAadhar');
form.addEventListener('submit',(e)=>{
e.preventDefault();
Validation();
});

function Validation()
{
    let userNameValue =   userName.value.trim();
    let userEmailValue  = userEmail.value.trim();
    let userPasswordValue = userPassword.value.trim();
    let userNumberValue = userNumber.value.trim();
    if(userNameValue =='')
    {
        setError(userName,"Please Enter Username")
    }
    else{
        setSuccess(userName);
    }
    if(userEmailValue =='')
    {
        setError(userEmail,"Please Enter Email")
    }
    else{
        setSuccess(userEmail);
    }
    if(userPasswordValue =='')
    {
        setError(userPassword,"Please Enter Password")
    }
    else{
        setSuccess(userPassword);
    }
    if(userNumberValue =='')
    {
        setError(userNumber,"Please Enter Number")
    }
    else{
        setSuccess(userNumber);
    }

}
function setError(element , message)
{
    let parent = element.parentElement;
let elements = parent.querySelector('#error');
elements.innerHTML=message;
element.classList.remove('success');
element.classList.add('error');
}
function setSuccess(element)
{
    let parent = element.parentElement;
    let elements = parent.querySelector('#error');
    elements.innerHTML=" ";
    element.classList.add('success');
    element.classList.remove('error');

}