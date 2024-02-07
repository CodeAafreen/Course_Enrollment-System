import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios'; 
const RegisterPage = () => {

  const [accountType, setAccountType] = useState("");

  const [account, setAccount] = useState({
    name: "",
    username: "",
    password: "",
    accountType: accountType
  })

  const handleChange = (e) => {
    const { name, value } = e.target;
    setAccount({ ...account, [name]: value });
  };



  const handleSubmit = (event) => {
    event.preventDefault();
    // Add your registration logic here
    axios
    .post("http://localhost:8080/signUp/", account,{
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(() =>{
      alert("Sign Up Was Successful.");
    

    }).catch((e) =>{
      console.error(e);
      alert("Sign Up Failed!!!");
    });
  };

  return (
    <div className="flex items-center justify-center h-screen">
      <form className="w-full max-w-md bg-white p-8" onSubmit={handleSubmit}>
        <div className="mb-4">
          <label htmlFor="name" className="block text-gray-700 text-sm font-bold mb-2">
            Name
          </label>
          <input
            type="text"
            id="name"
            name="name"
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Enter your Full Name"
            required
            onChange={handleChange}
          />
        </div>
        <div className="mb-4">
          <label htmlFor="email" className="block text-gray-700 text-sm font-bold mb-2">
            Username
          </label>
          <input
            type="username"
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
            required
            onChange={handleChange}
          />
        </div>

        
          <div className="mb-6">
            <input onChange={handleChange} type="radio" id="teacher" name="accountType" value="Teacher" />
            <label htmlFor="teacher">Teacher</label>
          </div>
          <div className="mb-6">
            <input onChange={handleChange} type="radio" id="student" name="accountType" value="Student" />
            <label htmlFor="student">Student</label>
          </div>
        

        <div className="flex items-center justify-between">
          <button
            type="submit"
            className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          >
            Register
          </button>
          <p className="text-sm">
            Already have an account?{' '}
            <Link to="/login" className="text-blue-500 hover:underline">
              Login here
            </Link>
          </p>
        </div>
      </form>
    </div>
  );
};

export default RegisterPage;
