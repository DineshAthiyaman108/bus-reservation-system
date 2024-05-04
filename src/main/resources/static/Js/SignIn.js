let userEmail = document.getElementById('userEmail');
let userPassword = document.getElementById('userPassword');
let userAadhar = document.getElementById('userAadhar'); // New: get userAadhar element
let form = document.getElementById('form');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    validateForm();
});

function validateForm() {
    let userEmailValue = userEmail.value.trim();
    let userPasswordValue = userPassword.value.trim();
    let userAadharValue = userAadhar.value.trim(); // New: get userAadhar value

    if (userEmailValue === '') {
        setError(userEmail, "Please enter your email");
    } else {
        setSuccess(userEmail);
    }

    if (userPasswordValue === '') {
        setError(userPassword, "Please enter your password");
    } else {
        setSuccess(userPassword);
    }

    if (isNaN(userAadharValue) || userPasswordValue === '' ){ // New: Validate userAadhar field
        setError(userAadhar, "Enter Aadhar number");
    } else {
        setSuccess(userAadhar);
    }

    // Only submit the form if all fields are filled
    if (userEmailValue !== '' && userPasswordValue !== '' && userAadharValue !== '') {
        form.submit();
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