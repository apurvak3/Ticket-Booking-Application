import React, { useState } from 'react';
import { Search, MapPin } from 'lucide-react';
import { Dialog, DialogContent, DialogHeader, DialogTitle } from '@shadcn/ui';
import { Input } from '@shadcn/ui';
import { Button } from '@shadcn/ui';;

const popularCities = [
  { name: 'Mumbai', icon: '🏙️' },
  { name: 'Delhi-NCR', icon: '🏛️' },
  { name: 'Bengaluru', icon: '🏢' },
  { name: 'Hyderabad', icon: '🕌' },
  { name: 'Ahmedabad', icon: '🕍' },
  { name: 'Chandigarh', icon: '🏛️' },
  { name: 'Chennai', icon: '🏯' },
  { name: 'Pune', icon: '🏛️' },
  { name: 'Kolkata', icon: '🏛️' },
  { name: 'Kochi', icon: '🌴' },
];

const CitySelectionModal = ({ isOpen, onClose, onSelectCity }) => {
  const [searchQuery, setSearchQuery] = useState('');

  const handleDetectLocation = () => {
    // Implement location detection logic here
    console.log('Detecting location...');
  };

  return (
    <Dialog open={isOpen} onOpenChange={onClose}>
      <DialogContent className="sm:max-w-[425px]">
        <DialogHeader>
          <DialogTitle>Select your city</DialogTitle>
        </DialogHeader>
        <div className="grid gap-4 py-4">
          <div className="relative">
            <Search className="absolute left-2 top-3 h-4 w-4 text-gray-500" />
            <Input
              placeholder="Search for your city"
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              className="pl-8"
            />
          </div>
          <Button onClick={handleDetectLocation} variant="outline" className="flex items-center">
            <MapPin className="mr-2 h-4 w-4" /> Detect my location
          </Button>
          <div>
            <h3 className="mb-2 text-sm font-medium">Popular Cities</h3>
            <div className="grid grid-cols-5 gap-4">
              {popularCities.map((city) => (
                <Button
                  key={city.name}
                  onClick={() => onSelectCity(city.name)}
                  variant="ghost"
                  className="flex flex-col items-center p-2"
                >
                  <span className="text-2xl mb-1">{city.icon}</span>
                  <span className="text-xs">{city.name}</span>
                </Button>
              ))}
            </div>
          </div>
          <Button variant="link" className="justify-start p-0 hover:no-underline">
            View All Cities
          </Button>
        </div>
      </DialogContent>
    </Dialog>
  );
};

export default CitySelectionModal;