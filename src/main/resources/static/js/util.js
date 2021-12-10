function getUser() {
    $.ajax({
        url:"/account/user",
        method:"get",
        dataType:"json",
        success: function (response) {
            var account = response.data;
            var role = response.role;

            return {
                id:account.id,
                number:account.accountNumber,
                password:account.password,
                type:account.accountType,
                name:role.name,
                phone:role.phone,
                email: role.email,
                grade: role.grade,
                classNumber: role.classNumber,
                major: role.major
            }
        },
    });
}