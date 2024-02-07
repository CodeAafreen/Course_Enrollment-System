import React from 'react';
import {BrowserRouter , Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import ProfilePage from './pages/ProfilePage';
import RegisterPage from './pages/RegisterPage';
import CourseDetailPage from './pages/CourseDetailPage';
import CourseListPage from './pages/CourseListPage';
import DashboardPage from './pages/DashboardPage';
import InstructorDetail from './pages/InstructorDetail';
import AdminDashBoard from './pages/AdminDashBoard';
import TeacherDashBard from './pages/TeacherDashBard';

const App = () => {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<DashboardPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/course" element={<CourseListPage />} />
      <Route path="/profile" element={<ProfilePage />} />
      <Route path="/coursedetail" element={<CourseDetailPage />} />
      <Route path="/instructor" element={<InstructorDetail />} />
      <Route path="/admindashBoard" element={<AdminDashBoard />} />
      <Route path="/teacherDashBoard" element={<TeacherDashBard />} />
    </Routes>
    </BrowserRouter>
  );
};

export default App;
