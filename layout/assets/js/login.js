var self;

var roles = {
    visitor: 10,
    student: 20,
    teacher: 30
}

var studentValidator = {
    email: "student@example.com",
    password: "1234"
}

var teacherValidator = {
    email: "teacher@example.com",
    password: "1234"
}

function checkValidation(email, password, validator) {
    return validator.email === email && validator.password === password;
}

function logIn() {
    var email = document.getElementsByName('email')[0].value;
    var password = document.getElementsByName('password')[0].value;

    if (checkValidation(email, password, studentValidator))
        window.location.href = './alumn-units.html';
    else if (checkValidation(email, password, teacherValidator))
        window.location.href = './teacher-units.html';
    else
        logOut();
}

var logOut = function () {
    window.location.href = './index.html';
}

self.role = roles.visitor;

