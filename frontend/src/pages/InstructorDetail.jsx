import React from 'react';

const InstructorDetail = () => {
  return (
    <section className="bg-gray-100 min-h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded shadow-md">
        <img
          src="instructor-image.jpg"
          alt="Instructor Image"
          className="w-32 h-32 rounded-full mx-auto mb-4"
        />
        <div className="text-center">
          <h2 className="text-xl font-bold">Instructor Name</h2>
          <p className="text-gray-600">Expert in: Subject of Expertise</p>
          <p className="text-gray-600">Email: instructor@email.com</p>
          <p className="text-gray-600">Phone: +1234567890</p>
          <p className="text-gray-600">Location: City, Country</p>
        </div>
      </div>
    </section>
  );
};

export default InstructorDetail;
