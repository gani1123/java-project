# Swiggy App Code

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Swiggy App</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Welcome to Swiggy</h1>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="menu.jsp">Menu</a></li>
                <li><a href="order.jsp">Order</a></li>
                <li><a href="contact.jsp">Contact Us</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h2>Explore Our Delicious Menu</h2>
        <div class="menu-item">
            <h3>Pizza</h3>
            <p>Delicious cheese pizza with fresh toppings.</p>
            <button onclick="order('Pizza')">Order Now</button>
        </div>
        <div class="menu-item">
            <h3>Burger</h3>
            <p>Juicy beef burger with crispy lettuce.</p>
            <button onclick="order('Burger')">Order Now</button>
        </div>
        <div class="menu-item">
            <h3>Pasta</h3>
            <p>Italian pasta with a rich tomato sauce.</p>
            <button onclick="order('Pasta')">Order Now</button>
        </div>
    </main>
    <footer>
        <p>&copy; 2023 Swiggy. All rights reserved.</p>
    </footer>
    <script>
        function order(item) {
            alert("You have ordered: " + item);
        }
    </script>
</body>
</html>
