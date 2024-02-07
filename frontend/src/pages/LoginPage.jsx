import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
const LoginPage = () => {

  const [logindata, setLogindata] = useState({
    username: "",
    password: "",
    accountType: ""
  })

  const handleChange = (e) => {
    const { name, value } = e.target;
    setLogindata({ ...logindata, [name]: value });
  };

  const navigate = useNavigate();



  const handleSubmit = (event) => {
    event.preventDefault();
    // Add your registration logic here
    console.log(logindata)
    axios
      .post("http://localhost:8080/login/", logindata, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        alert("Login Was Successful.");
        setLogindata(response.data)
        if (logindata.accountType === 'admin') {
          navigate('/admindashBoard')
        }
        else if (logindata.accountType === 'Teacher') {
          navigate('/teacherDashboard')
        }

      }).catch((e) => {
        console.error(e);
        alert("Login Failed!!!");
      });
  };

  if (logindata.accountType === 'admin') {
    navigate('/admindashBoard')
  }
  else if (logindata.accountType === 'Teacher') {
    navigate('/teacherDashboard')
  }
  return (
    <div className="flex items-center justify-center h-screen">
      <form className="w-full max-w-md bg-white p-8" onSubmit={handleSubmit}>
        <div className="mb-4">
          <label htmlFor="username" className="block text-gray-700 text-sm font-bold mb-2">
            Username
          </label>
          <input
            type="text"
            id="username"
            name="username"
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Enter your username"
            required
            onChange={handleChange}
          />
        </div>
        <div className="mb-6">
          <label htmlFor="password" className="block text-gray-700 text-sm font-bold mb-2">
            Password
          </label>
          <input
            type="password"
            id="password"
            name="password"
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Enter your password"
            onChange={handleChange}
            required
          />
        </div>
        <div className="flex items-center justify-between">
          <button
            type="submit"
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          >
            Login
          </button>
          <p className="text-sm">
            Don't have an account?{' '}
            <Link to="/register" className="text-blue-500 hover:underline">
              Register here
            </Link>
          </p>
        </div>
      </form>
    </div>
  );
};

export default LoginPage;

