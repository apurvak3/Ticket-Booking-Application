import React, { useState } from "react";
import { Calendar, Clock } from "lucide-react";

export default function SeatBooking({ movieTitle, onBookSeats }) {
  const [selectedDate, setSelectedDate] = useState(null);
  const [selectedTime, setSelectedTime] = useState(null);
  const [selectedSeats, setSelectedSeats] = useState([]);

  const dates = [21, 22, 23, 24, 25, 26, 27];
  const times = ["13:15", "15:15", "18:15", "20:30", "22:30"];

  // Generate a 8x8 grid of seats
  const seats = Array(8)
    .fill()
    .map(() => Array(8).fill(false));

  const handleDateSelect = (date) => setSelectedDate(date);
  const handleTimeSelect = (time) => setSelectedTime(time);

  const handleSeatSelect = (row, col) => {
    const seatId = `${row}-${col}`;
    setSelectedSeats((prev) =>
      prev.includes(seatId)
        ? prev.filter((id) => id !== seatId)
        : [...prev, seatId]
    );
  };

  const handleBooking = () => {
    if (selectedDate && selectedTime && selectedSeats.length > 0) {
      onBookSeats({
        date: selectedDate,
        time: selectedTime,
        seats: selectedSeats,
      });
    } else {
      alert("Please select a date, time, and at least one seat.");
    }
  };

  return (
    <div className="max-w-4xl mx-auto mt-10 bg-gray-900 text-white p-6 rounded-lg">
      <h2 className="text-2xl font-bold mb-4">{movieTitle} - Seat Booking</h2>

      {/* Date Selection */}
      <div className="mb-4">
        <h3 className="text-lg font-semibold mb-2 flex items-center">
          <Calendar className="mr-2" /> Select Date
        </h3>
        <div className="flex space-x-2">
          {dates.map((date) => (
            <button
              key={date}
              onClick={() => handleDateSelect(date)}
              className={`w-10 h-10 rounded-full ${
                selectedDate === date ? "bg-red-600" : "bg-gray-700"
              }`}
            >
              {date}
            </button>
          ))}
        </div>
      </div>

      {/* Time Selection */}
      <div className="mb-4">
        <h3 className="text-lg font-semibold mb-2 flex items-center">
          <Clock className="mr-2" /> Select Time
        </h3>
        <div className="flex flex-wrap gap-2">
          {times.map((time) => (
            <button
              key={time}
              onClick={() => handleTimeSelect(time)}
              className={`px-4 py-2 rounded ${
                selectedTime === time ? "bg-red-600" : "bg-gray-700"
              }`}
            >
              {time}
            </button>
          ))}
        </div>
      </div>

      {/* Seat Selection */}
      <div className="mb-4">
        <h3 className="text-lg font-semibold mb-2">Select Seats</h3>
        <div className="grid grid-cols-8 gap-1 mb-4">
          {seats.map((row, rowIndex) =>
            row.map((_, colIndex) => (
              <button
                key={`${rowIndex}-${colIndex}`}
                onClick={() => handleSeatSelect(rowIndex, colIndex)}
                className={`w-8 h-8 rounded-sm ${
                  selectedSeats.includes(`${rowIndex}-${colIndex}`)
                    ? "bg-red-600"
                    : "bg-gray-700"
                }`}
              >
                {String.fromCharCode(65 + rowIndex)}
                {colIndex + 1}
              </button>
            ))
          )}
        </div>
      </div>

      {/* Selected Seats Info */}
      {selectedSeats.length > 0 && (
        <div className="bg-gray-800 p-4 rounded mb-4">
          <h4 className="font-semibold">SELECTED SEATS</h4>
          <p>
            {selectedSeats
              .map((seat) => {
                const [row, col] = seat.split("-");
                return `${String.fromCharCode(65 + parseInt(row))}${
                  parseInt(col) + 1
                }`;
              })
              .join(", ")}
          </p>
          <p>Total: ${selectedSeats.length * 12}</p>
        </div>
      )}

      {/* Book Button */}
      <button
        onClick={handleBooking}
        className="w-full bg-red-600 py-2 rounded font-semibold"
      >
        Book Seats
      </button>
    </div>
  );
}
