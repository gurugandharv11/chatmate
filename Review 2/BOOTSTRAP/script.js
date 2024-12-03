    <!-- ChatMate JavaScript -->
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Smooth scroll for navigation links
            const navLinks = document.querySelectorAll('.nav-link');
            navLinks.forEach(link => {
                link.addEventListener('click', function (e) {
                    e.preventDefault();
                    const targetId = this.getAttribute('href').substring(1);
                    const targetElement = document.getElementById(targetId);
                    if (targetElement) {
                        targetElement.scrollIntoView({ behavior: 'smooth' });
                    }
                });
            });

            // Contact form submission handler
            const contactForm = document.querySelector('form');
            contactForm.addEventListener('submit', function (e) {
                e.preventDefault();

                const name = document.getElementById('name').value;
                const email = document.getElementById('email').value;
                const message = document.getElementById('message').value;

                if (name && email && message) {
                    alert(`Thank you, ${name}! Your message has been sent.`);
                    contactForm.reset();
                } else {
                    alert('Please fill in all fields before submitting.');
                }
            });
        });
    </script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
