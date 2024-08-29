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
    title: "Beauty And The Beast",
    year: "2014",
    image: "https://m.media-amazon.com/images/M/MV5BMTUwNjUxMTM4NV5BMl5BanBnXkFtZTgwODExMDQzMTI@._V1_SX300.jpg",
  },
  {
    title: "Beauty And The Beast",
    year: "2017",
    image: "https://m.media-amazon.com/images/M/MV5BMTQxNjI2NjU4MV5BMl5BanBnXkFtZTcwNjQ2NjUwNw@@._V1_SX300.jpg",
  },
  {
    title: "Beauty And The Beast",
    year: "2015",
    image: "https://m.media-amazon.com/images/M/MV5BNmE1Yjk0NzMtOWM3NC00YTgzLWJlMDItMjJlMGM4ZGE3NjJkXkEyXkFqcGc@._V1_SX300.jpg",
    bg_image: "https://m.media-amazon.com/images/M/MV5BNTE4NDIwMDQ4OF5BMl5BanBnXkFtZTgwMDcyMDg2MTI@._V1_.jpg",
  },
  {
    title: "RRR",
    year: "2022",
    image: "https://m.media-amazon.com/images/M/MV5BOGU1YWRlOTUtMmY3Yi00NzgzLWI3ZDYtM2M4YWQ1NWVmZjk5XkEyXkFqcGdeQXVyMTQ3Mzk2MDg4._V1_.jpg",
    bg_image: "https://wallpaperaccess.com/full/5664306.jpg"
  },
];

function Header() {
  const [backgroundImage, setBackgroundImage] = useState("https://wallpaperaccess.com/full/1679629.jpg");
  const [showAll, setShowAll] = useState(false);
  const [isHovered, setIsHovered] = useState(false);

  const handleMouseEnter = (bg_image) => {
    setBackgroundImage(bg_image);
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
    setBackgroundImage("https://wallpaperaccess.com/full/1679629.jpg");
  };

  const visibleMovies = showAll ? movies : movies.slice(0, 4); // Adjust the logic for showing more or less movies

  return (
    <>
      <header
        className="hero relative"
        style={{
          backgroundImage: backgroundImage ? `url(${backgroundImage})` : "https://wallpaperaccess.com/full/1679629.jpg",
          backgroundSize: "cover",
          backgroundPosition: "center",
          transition: "background-image 0.3s ease-in-out",
        }}
      >
        <button
          onClick={() => setShowAll(!showAll)}
          className="text-blue-500 hover:text-blue-700 transition-colors duration-300 absolute down-10 right-5"
        >
          {showAll ? "See Less" : "See More"}
        </button>

        <Navbar />
        <div className="grid grid-cols-4 absolute bottom-0 gap-4 p-4">
          {visibleMovies.map((movie, index) => (
            <Card
              key={index}
              shadow={false}
              className={`ms-5 relative grid h-[${isHovered ? "25rem" : "15rem"}] w-full max-w-[14rem] items-end justify-center overflow-hidden text-center`}
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
              <CardBody className="relative py-14 px-6 md:px-12">
                <Typography
                  variant="h2"
                  color="white"
                  className="mb-6 font-medium leading-[1.5]"
                >
                  {movie.title}
                </Typography>
                <Typography variant="h5" className="mb-4 text-gray-400">
                  {movie.year}
                </Typography>
              </CardBody>
            </Card>
          ))}
        </div>
      </header>
    </>
  );
}

export default Header;
