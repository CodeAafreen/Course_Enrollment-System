import React from 'react';
import { Link } from 'react-router-dom';
import CourseCard from '../components/CourseCard';

const DashboardPage = ({course}) => {
  return (
    <div style={{justifyContent:'flex-start'}} className="flex flex-col items-center justify-center min-h-screen">
      <header className="bg-blue-500 px-28 w-full">
        <nav className="flex items-center justify-between w-[50%]">
          <Link to="/" className="text-white font-bold text-xl">
            Dashboard
          </Link>
          <div className="flex space-x-4">
            <Link to="/profile" className="text-white hover:underline ">
              Profile
            </Link>
            <Link to="/course" className="text-white hover:underline">
              Course List
            </Link>
            <Link to="/login" className="text-white hover:underline">
              Login
            </Link>
          </div>
        </nav>
      </header>
      <div className="container mx-auto p-4 bg-white rounded-lg shadow-lg mt-8">
        <h1 className="text-3xl font-bold mb-4">Welcome to the Dashboard</h1>
        <p className="text-lg">
         Courses we provoid
        </p>
        <div className='w-full gap-8 flex flex-wrap'>
            <CourseCard  title="python" description="we provoid dsa , machine learning" instructor="xyz" duration="4hr"/>
            <CourseCard  title="Java" description="we provoid dsa , machine learning" instructor="xyz" duration="4hr"/>
        </div>
      </div>
    </div>
  );
};

export default DashboardPage;
