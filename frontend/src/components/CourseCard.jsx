import React from 'react';
import { Link } from 'react-router-dom';

const CourseCard = ({title , description , instructor, duration}) => {
  return (
    <div className="bg-white rounded-lg shadow-lg p-6 mb-4">
      <h2 className="text-2xl font-bold mb-4">{title}</h2>
      <p className="text-gray-700 mb-4">{description}</p>
      <div className="flex justify-between items-center">
        <Link to="/instructor" className="text-blue-500">{instructor}</Link>
        <span className="text-gray-500">{duration}</span>
      </div>
    </div>
  );
};

export default CourseCard;
