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
  },
  {
    title: "Beauty And The Beast",
    year: "2010",
    image: "https://m.media-amazon.com/images/M/MV5BMjI2MDQ0ODA2Ml5BMl5BanBnXkFtZTcwODU1MDY5NA@@._V1_SX300.jpg",
  },
];

function Header() {
  const [backgroundImage, setBackgroundImage] = useState("hero.jpg");
  const [showAll, setShowAll] = useState(false);

  const handleMouseEnter = (image) => {
    setBackgroundImage(image);
  };

  const handleMouseLeave = () => {
    setBackgroundImage("");
  };

  const visibleMovies = showAll ? movies : movies.slice(0, 4); // Adjust the logic for showing more or less movies

  return (
    <>
      <header
        className="hero relative"
        style={{
          backgroundImage: backgroundImage ? `url(${backgroundImage})` : "hero.jpg",
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
              className="ms-5 relative grid h-[10rem] w-full max-w-[14rem] items-end justify-center overflow-hidden text-center"
              onMouseEnter={() => handleMouseEnter(movie.image)}
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
