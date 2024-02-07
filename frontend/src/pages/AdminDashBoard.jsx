import React, { useState } from 'react'
import axios from 'axios';
const AdminDashBoard = () => {

  const [course,setCourse] = useState({
    coursename:'',
    maxStudent:'',
    maxTeacher:''
  })

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCourse({ ...course, [name]: value });
  };



  const handleSubmit = (event) => {
    event.preventDefault();
    // Add your registration logic here
    axios
    .post("http://localhost:8080/course/add", course,{
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(() =>{
      console.log(course)
      alert("Course added Successful.");
    

    }).catch((e) =>{
      console.error(e);
      alert("Something went wrong");
    });
  };

  return (
    <div className="flex items-center justify-center h-screen">
      <form className="w-full max-w-md bg-white p-8" onSubmit={handleSubmit}>
        <h2>Add a New Course</h2>
        <div className="mb-4">
          <label htmlFor="coursename" className="block text-gray-700 text-sm font-bold mb-2">
            Course Name
          </label>
          <input
            type="coursename"
            id="coursename"
            name="coursename"
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Enter coursename"
            required
            onChange={handleChange}
          />
        </div>
        <div className="mb-4">
          <label htmlFor="maxTeacher" className="block text-gray-700 text-sm font-bold mb-2">
            Max Teacher
          </label>
          <input
            type="maxTeacher"
            id="maxTeacher"
            name="maxTeacher"
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Enter coursename"
            required
            onChange={handleChange}
          />
        </div>
        <div className="mb-4">
          <label htmlFor="maxStudent" className="block text-gray-700 text-sm font-bold mb-2">
            Max student
          </label>
          <input
            type="maxStudent"
            id="maxStudent"
            name="maxStudent"
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Enter coursename"
            required
            onChange={handleChange}
          />
        </div>
        <div className="flex items-center justify-between">
          <button
            type="submit"
            className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          >
            Add Course
          </button>
        </div>
      </form>
    </div>
  )
}

export default AdminDashBoard