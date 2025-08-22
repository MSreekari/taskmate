import React from 'react'

const Navbar = () => {
  return (
<div className="w-full flex justify-center pt-10">
      <div className="">
        <h1 className="text-2xl font-semibold text-white-900">TaskMate</h1>
        <nav className="bg-black px-10 py-5 rounded text-lg">
          <a href="#" className="hover:text-white transition">Home</a>
          <a href="#" className="hover:text-white transition">About</a>
          <a href="#" className="hover:text-white transition">Dashboard</a>
        </nav>
      </div>
    </div>
  )
}

export default Navbar