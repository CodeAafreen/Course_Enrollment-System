import React from 'react';
import { Link } from 'react-router-dom';

const CourseListPage = () => {
  // Mock data for course list
  const courseList = [
    { id: 1, name: 'Mathematics 101' },
    { id: 2, name: 'General Science 201' },
    { id: 3, name: 'History 301' },
    // Add more courses as needed
  ];

  return (
    <div className="container mx-auto mt-8">
      <div className="max-w-md mx-auto bg-white p-8 border rounded shadow-md">
        <h2 className="text-2xl font-bold mb-4">Course List</h2>
        <ul>
          {courseList.map((course) => (
            <li key={course.id} className="mb-2">
              <Link to={`/course/${course.id}`} className="text-blue-500 hover:underline">
                {course.name}
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default CourseListPage;

