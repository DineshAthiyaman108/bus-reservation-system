let adminName= document.getElementById('adminName');
let adminPassword = document.getElementById('adminPassword');
let form = document.getElementById('form');
let flag = true;
form.addEventListener('submit', (e) => {
        e.preventDefault();
        validateForm();  



    
});


function validateForm() {
    let adminValue = adminName.value.trim();
    let adminPasswordValue = adminPassword.value.trim();

    if (adminValue === '') {
        setError(adminName, "Please enter your email");
    } else {
        setSuccess(adminName);
    }

    if (adminPasswordValue === '') {
        setError(adminPassword, "Please enter your password");
    } else {
        setSuccess(adminPassword);

    }
    if(adminValue!=null && adminPasswordValue !=null)
        {
            form.submit()
        }
}

function setError(element, message) {
    let parent = element.parentElement;
    let elements = parent.querySelector('#error');
    elements.innerHTML=message;
    elements.classList.remove('success');
    elements.classList.add('error');
   
}

function setSuccess(element) {
    let parent = element.parentElement;
    let elements = parent.querySelector('#error');
    elements.innerHTML=" ";
    element.classList.add('success');
    element.classList.remove('error');

}
