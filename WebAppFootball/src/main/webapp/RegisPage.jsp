<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        *
        {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }
        .page
        {
            width: 100%;
            height: 100vh;
            background-color: rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            overflow: hidden;
        }
        .regis-frame
        {
            width: 20%;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.5);
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;
            gap: 15px;
            align-items: center;
            z-index: 1;
        }
        img
        {
            width: 60px; /* Điều chỉnh kích thước logo nhỏ hơn */
            height: auto;
            margin-bottom: 2px;
        }
        .regis-frame h2
        {
            color: black;
            margin-bottom: 2px;
        }
        .input-group
        {
            width: 100%;
            display: flex;
            flex-direction: column;
        }
        .input-group label
        {
            margin-bottom: 2px;
            color: #333;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            font-size: 14px;
        }
        .input-group input
        {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            width: 100%;
        }
        .button-submit
        {
            display: flex;
            justify-content: center; /* Căn giữa nút Submit */
            width: 100%;
            margin-top: 10px;
        }
        .button-submit input[type="submit"]
        {
            width: 100%; /* Thay đổi để nút Submit chiếm toàn bộ chiều rộng */
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button-submit input[type="submit"]:hover
        {
            background-color: #45a049;
        }
        .background-clip
        {
            position: absolute;
            right: 0;
            bottom: 0;
            z-index: -1;
        }
        @media (min-aspect-ratio: 16/9)
        {
            .background-clip
            {
                width: 100%;
                height: auto;
            }
        }
        @media (max-aspect-ratio: 16/9)
        {
            .background-clip
            {
                width: auto;
                height: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="page">
        <!-- Thêm thẻ form vào đây -->
        <form action="/WebAppFootball/RGSever" method="post" class="regis-frame">
            <h2>Register</h2>
            <img src="Image/logoweb.png" alt="Logo">
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username">
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password">
            </div>
            <!-- Thêm các nút Login và Register -->
            <div class="button-submit">
                <input type="submit" value="Submit" name="Submit">
            </div>
        </form>
        <video autoplay loop muted plays-inline class="background-clip">
            <source src="Image/background-clip.mp4" type="video/mp4">
        </video>
    </div>
</body>
</html>
