import React from 'react';
import { useParams } from 'react-router-dom';

const CourseDetailPage = () => {
  const { courseId } = useParams();

  // Mock data for course details
  const courseDetails = {
    id: courseId,
    name: 'Mathematics 101',
    description: 'Introduction to Mathematics',
    // Add more details as needed
  };

  return (
    <div className="container mx-auto mt-8">
      <div className="max-w-md mx-auto bg-white p-8 border rounded shadow-md">
        <h2 className="text-2xl font-bold mb-4">Course Detail: {courseDetails.name}</h2>
        <p className="text-gray-800 mb-4">
          <strong>ID:</strong> {courseDetails.id}
        </p>
        <p className="text-gray-800">
          <strong>Description:</strong> {courseDetails.description}
        </p>
        {/* Add more course details as needed */}
      </div>
    </div>
  );
};

export default CourseDetailPage;
