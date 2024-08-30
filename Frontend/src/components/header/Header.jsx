import React, { useState } from "react";
import "./header.css";
import Navbar from "./Navbar";
import {
  Card,
  CardHeader,
  CardBody,
  Typography,
} from "@material-tailwind/react";

const movies = [
  {
    title: "RRR",
    year: "2022",
    image:
      "https://m.media-amazon.com/images/M/MV5BOGU1YWRlOTUtMmY3Yi00NzgzLWI3ZDYtM2M4YWQ1NWVmZjk5XkEyXkFqcGdeQXVyMTQ3Mzk2MDg4._V1_.jpg",
    bg_image: "https://wallpaperaccess.com/full/5664306.jpg",
  },
  {
    title: "Beauty And The Beast",
    year: "2014",
    image:
      "https://m.media-amazon.com/images/M/MV5BMTUwNjUxMTM4NV5BMl5BanBnXkFtZTgwODExMDQzMTI@._V1_SX300.jpg",
  },
  {
    title: "Beauty And The Beast",
    year: "2017",
    image:
      "https://m.media-amazon.com/images/M/MV5BMTQxNjI2NjU4MV5BMl5BanBnXkFtZTcwNjQ2NjUwNw@@._V1_SX300.jpg",
  },
  {
    title: "Beauty And The Beast",
    year: "2015",
    image:
      "https://m.media-amazon.com/images/M/MV5BNmE1Yjk0NzMtOWM3NC00YTgzLWJlMDItMjJlMGM4ZGE3NjJkXkEyXkFqcGc@._V1_SX300.jpg",
    bg_image:
      "https://m.media-amazon.com/images/M/MV5BNTE4NDIwMDQ4OF5BMl5BanBnXkFtZTgwMDcyMDg2MTI@._V1_.jpg",
  },
  {
    title: "RRR",
    year: "2022",
    image:
      "https://m.media-amazon.com/images/M/MV5BOGU1YWRlOTUtMmY3Yi00NzgzLWI3ZDYtM2M4YWQ1NWVmZjk5XkEyXkFqcGdeQXVyMTQ3Mzk2MDg4._V1_.jpg",
    bg_image: "https://wallpaperaccess.com/full/5664306.jpg",
  },
];

function Header() {
  const [backgroundImage, setBackgroundImage] = useState(
    "https://wallpaperaccess.com/full/1679629.jpg"
  );
  const [showAll, setShowAll] = useState(false);

  const handleMouseEnter = (bg_image) => {
    setBackgroundImage(
      bg_image || "https://wallpaperaccess.com/full/1679629.jpg"
    );
  };

  const handleMouseLeave = () => {
    setBackgroundImage("https://wallpaperaccess.com/full/1679629.jpg");
  };

  const visibleMovies = showAll ? movies : movies.slice(0, 5);

  return (
    <>
      <header
        className="hero relative h-screen"
        style={{
          backgroundImage: `url(${backgroundImage})`,
          backgroundSize: "cover",
          backgroundPosition: "center",
          transition: "background-image 0.3s ease-in-out",
        }}
      >
        <Navbar />
        <button
          onClick={() => setShowAll(!showAll)}
          className="text-blue-500 hover:text-blue-700 transition-colors duration-300 absolute bottom-4 right-4 z-20"
        >
          {showAll ? "See Less" : "See More"}
        </button>
        <div className="absolute bottom-0 left-0 right-0 overflow-x-auto whitespace-nowrap pb-4">
          <div className="flex justify-evenly space-x-4 px-4">
            {visibleMovies.map((movie, index) => (
              <div key={index} className="relative w-[12rem] h-[15rem]">
                <Card
                  shadow={false}
                  className="w-full h-full transition-all duration-300 ease-in-out transform hover:w-[14rem] hover:h-[16rem] hover:z-10"
                  onMouseEnter={() => handleMouseEnter(movie.bg_image)}
                  onMouseLeave={handleMouseLeave}
                >
                  <CardHeader
                    floated={false}
                    shadow={false}
                    color="transparent"
                    className="absolute inset-0 m-0 h-full w-full rounded-none bg-cover bg-center"
                    style={{ backgroundImage: `url(${movie.image})` }}
                  >
                    <div className="to-bg-black-10 absolute inset-0 h-full w-full bg-gradient-to-t from-black/80 via-black/50" />
                  </CardHeader>
                  <CardBody className="relative flex flex-col justify-end h-full py-4 px-6">
                    <Typography
                      variant="h2"
                      color="white"
                      className="mb-2 font-medium leading-[1.5] text-sm"
                    >
                      {movie.title}
                    </Typography>
                    <Typography variant="h5" className="text-gray-400 text-xs">
                      {movie.year}
                    </Typography>
                  </CardBody>
                </Card>
              </div>
            ))}
          </div>
        </div>
      </header>
    </>
  );
}

export default Header;
