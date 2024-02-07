import React from 'react';

const ProfilePage = () => {
  return (
    <div className="container mx-auto mt-8">
      <div className="max-w-md mx-auto bg-white p-8 border rounded shadow-md">
        <h2 className="text-2xl font-bold mb-4">Profile</h2>
        <div className="mb-4">
          <label htmlFor="username" className="block text-gray-700 text-sm font-bold mb-2">
            Username
          </label>
          <p className="text-gray-800">john_doe</p>
        </div>
        <div className="mb-4">
          <label htmlFor="email" className="block text-gray-700 text-sm font-bold mb-2">
            Email
          </label>
          <p className="text-gray-800">john.doe@example.com</p>
        </div>
        {/* Add more profile details as needed */}
      </div>
    </div>
  );
};

export default ProfilePage;
