document.addEventListener("DOMContentLoaded", () => {
    // Registration Form Validation
    <
    script src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity = "sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin = "anonymous" > < /script>
    document.addEventListener("DOMContentLoaded", () => {
        const loginForm = document.getElementById("loginForm");

        loginForm.addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent form submission
            validateForm();
        });

        function validateForm() {
            // Clear previous errors
            clearErrors();

            // Input fields
            const email = document.getElementById("email").value.trim();
            const password = document.getElementById("password").value.trim();

            let isValid = true;

            // Email validation
            if (!email) {
                showError("emailError", "Email is required.");
                isValid = false;
            } else if (!isValidEmail(email)) {
                showError("emailError", "Enter a valid email address.");
                isValid = false;
            }

            // Password validation
            if (!password) {
                showError("passwordError", "Password is required.");
                isValid = false;
            } else if (password.length < 6) {
                showError("passwordError", "Password must be at least 6 characters long.");
                isValid = false;
            }

            // If valid, show success message
            if (isValid) {
                alert("Login successful!");
                // Here you can add logic to submit the form or redirect the user
            }
        }

        function showError(id, message) {
            const errorElement = document.getElementById(id);
            errorElement.textContent = message;
        }

        function clearErrors() {
            const errorMessages = document.querySelectorAll("small.text-danger");
            errorMessages.forEach((error) => (error.textContent = ""));
        }

        function isValidEmail(email) {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return emailRegex.test(email);
        }
    });

    const registrationForm = document.querySelector("#registrationForm");
    if (registrationForm) {
        registrationForm.addEventListener("submit", (event) => {
            const username = document.querySelector("#username").value.trim();
            const email = document.querySelector("#email").value.trim();
            const password = document.querySelector("#password").value.trim();

            if (!username || !email || !password) {
                event.preventDefault();
                alert("All fields are required.");
                return;
            }

            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                event.preventDefault();
                alert("Please enter a valid email address.");
                return;
            }

            if (password.length < 6) {
                event.preventDefault();
                alert("Password must be at least 6 characters long.");
            }
        });
    }
});
document.addEventListener("DOMContentLoaded", () => {
    const userTable = document.querySelector("#userTable tbody");
    const addUserForm = document.querySelector("#addUserForm");

    // Add New User
    if (addUserForm) {
        addUserForm.addEventListener("submit", (event) => {
            event.preventDefault();
            const username = document.querySelector("#newUsername").value.trim();
            const email = document.querySelector("#newEmail").value.trim();

            if (!username || !email) {
                alert("Username and Email are required.");
                return;
            }

            const newRow = document.createElement("tr");
            newRow.innerHTML = `
                <td>${userTable.rows.length + 1}</td>
                <td>${username}</td>
                <td>${email}</td>
                <td>
                    <button class="deleteUser">Delete</button>
                </td>
            `;
            userTable.appendChild(newRow);

            // Clear form inputs
            document.querySelector("#newUsername").value = "";
            document.querySelector("#newEmail").value = "";

            attachDeleteEvents();
        });
    }

    // Attach delete event to all delete buttons
    function attachDeleteEvents() {
        const deleteButtons = document.querySelectorAll(".deleteUser");
        deleteButtons.forEach((button) => {
            button.addEventListener("click", (event) => {
                const row = event.target.closest("tr");
                userTable.removeChild(row);
            });
        });
    }

    attachDeleteEvents();
});
document.addEventListener("DOMContentLoaded", () => {
    const usernameInput = document.querySelector("#username");
    const emailInput = document.querySelector("#email");
    const previewUsername = document.querySelector("#previewUsername");
    const previewEmail = document.querySelector("#previewEmail");

    if (usernameInput && emailInput && previewUsername && previewEmail) {
        usernameInput.addEventListener("input", () => {
            previewUsername.textContent = usernameInput.value.trim() || "Your Username";
        });

        emailInput.addEventListener("input", () => {
            previewEmail.textContent = emailInput.value.trim() || "your.email@example.com";
        });
    }
}); <
form id = "registrationForm"
action = "/register"
method = "POST" >
    <
    label
for = "username" > Username: < /label> <
input type = "text"
id = "username"
name = "username"
required >

    <
    label
for = "email" > Email: < /label> <
input type = "email"
id = "email"
name = "email"
required >

    <
    label
for = "password" > Password: < /label> <
input type = "password"
id = "password"
name = "password"
required >

    <
    button type = "submit" > Register < /button> < /
form > <
    script src = "scripts.js" > < /script> <
table id = "userTable" >
    <
    thead >
    <
    tr >
    <
    th > # < /th> <
th > Username < /th> <
th > Email < /th> <
th > Actions < /th> < /
tr > <
    /thead> <
tbody >
    <
    tr >
    <
    td > 1 < /td> <
td > john_doe < /td> <
td > john @example.com < /td> <
td >
    <
    button class = "deleteUser" > Delete < /button> < /
td > <
    /tr> < /
tbody > <
    /table>

<
form id = "addUserForm" >
    <
    input type = "text"
id = "newUsername"
placeholder = "New Username"
required >
    <
    input type = "email"
id = "newEmail"
placeholder = "New Email"
required >
    <
    button type = "submit" > Add User < /button> < /
form >

    <
    script src = "scripts.js" > < /script>