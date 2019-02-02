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

function logIn(email, password) {
    if (checkValidation(email, password, studentValidator))
        ;
    else if (checkValidation(email, password, teacherValidator))
        ;
}

self.role = roles.visitor;

return self;