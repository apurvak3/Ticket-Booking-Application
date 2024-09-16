import React from 'react';
import { FaInstagram, FaTwitter, FaFacebook } from 'react-icons/fa'; // Importing the icons

const Card = ({ children }) => <div className="bg-white shadow-md rounded-lg">{children}</div>;
const CardHeader = ({ children }) => <div className="p-4 border-b">{children}</div>;
const CardContent = ({ children }) => <div className="p-4">{children}</div>;
const newsItems = [
  {
    date: '25.03.2022',
    title: 'An event titled "April battles and victory" dedicated to the Armed Forces Day was held at the Nizami Cinema Center',
    image: 'pic1.jpg'
  },
  {
    date: '27.04.2022',
    title: '"Khazri" dance group at Nizami Cinema Center',
    image: 'pic2.jpg'
  },
  {
    date: '26.04.2022',
    title: 'The conference "Azerbaijani cinema" was held at the Nizami Cinema Center',
    image: 'pic3.jpg'
  },
  {
    date: '01.02.2022',
    title: 'The conference "Heydar Aliyev and Azerbaijani cinema" was held at the Nizami Cinema Center',
    image: 'pic4.jpg'
  }
];

function Footer() {
  return (
    <div>
      <footer>
        <div className="container mx-auto p-4">
          <h1 className="text-3xl font-bold mb-6">Movie Ticket Website</h1>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            {/* Featured Movie first */}
            <Card>
              <CardHeader>
                <h2 className="text-2xl font-semibold">Featured Movie</h2>
              </CardHeader>
              <CardContent>
                <div className="flex items-center space-x-4">
                  <img src="allah2.jpg" alt="Movie Poster" className="w-1/3" />
                  <div>
                    <h3 className="text-xl font-bold">Arshin Mal Alan</h3>
                    <p className="text-sm text-gray-600">
                      Arshin Mal Alan is a 4-act operetta composed by Azerbaijani composer Uzeyir Hajibeyov. The libretto
                      of the work was also written by Uzeyir Hajibeyov in 1913 in St. Petersburg. The premiere of the
                      opera was held on October 25, 1913 at the Haji Zeynalabdin Taghiyev Theater in Baku.
                    </p>
                  </div>
                </div>
              </CardContent>
            </Card>

            {/* About Us second */}
            <Card>
              <CardHeader>
                <h2 className="text-2xl font-semibold">About Us</h2>
              </CardHeader>
              <CardContent>
                <p className="text-sm text-gray-600 mb-4">
                  According to the State Program for the Development of Azerbaijan Cinema for 2008-2018, this unit, one
                  of the oldest cinemas in the country, was inaugurated on December 27, 2011 after major reconstruction.
                  In addition to the current repertoire of films, which includes the most interesting new films,
                  presentations of national films...
                </p>
                <img src="hero.jpg" alt="hero.jpg" className="w-full" />
              </CardContent>
            </Card>
          </div>
        </div>
      </footer>

      <div className="mt-8">
        <h2 className="text-2xl font-semibold mb-4">Latest News</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <Card className="col-span-2 md:col-span-1">
            <img src="pic5.jpg" alt="New American films" className="w-3/4 h-60 object-cover rounded" />
            <CardContent>
              <h3 className="text-lg font-semibold">
                New American films on the screen of Nizami Cinema Center
              </h3>
              <p className="text-sm text-gray-600">
                US-produced "Independence Day: Revival" at Nizami Cinema Center. "Neighbours: 2 in wartime" films have
                been shown. "Independence Day: Revival" is based on a screenplay by Nicholas Wright and directed by
                Roland Emmerich in the genres of science fiction, adventure and war. Slogan: "We had 20 years to
                prepare."
              </p>
            </CardContent>
          </Card>
          <div className="space-y-4">
            {newsItems.map((item, index) => (
              <div key={index} className="flex items-start space-x-4">
                <img src={item.image} alt={item.title} className="w-20 h-20 object-cover rounded" />
                <div>
                  <p className="text-sm text-gray-500">{item.date}</p>
                  <p className="text-sm">{item.title}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>

      <footer className="bg-gray-100 mt-12">
        <div className="container mx-auto py-8 px-4">
          <div className="grid grid-cols-1 md:grid-cols-4 gap-8">
            <div>
              <h3 className="font-semibold mb-2">PROFILE</h3>
              <ul className="space-y-1 text-sm">
                <li>FAQ's</li>
                <li>Pricing plans</li>
                <li>Order tracking</li>
                <li>Returns</li>
              </ul>
            </div>
            <div>
              <h3 className="font-semibold mb-2">RECENT POSTS</h3>
              <ul className="space-y-1 text-sm">
                <li>Touch of uniqueness</li>
                <li>Offices you won't forget</li>
                <li>Cician</li>
              </ul>
            </div>
            <div>
              <h3 className="font-semibold mb-2">CUSTOMER</h3>
              <ul className="space-y-1 text-sm">
                <li>Help & contact us</li>
                <li>Return</li>
                <li>Online stores</li>
                <li>Terms & condition</li>
              </ul>
            </div>
            <div>
              <h3 className="font-semibold mb-2">CONTACT</h3>
              <div className="flex space-x-4 text-gray-600">
                <FaInstagram size={20} />
                <FaTwitter size={20} />
                <FaFacebook size={20} />
              </div>
            </div>
          </div>
          <div className="mt-8 text-center text-sm text-gray-600">
            © 2024 Nizami Cinema. All Rights Reserved.
          </div>
        </div>
      </footer>
    </div>
  );
}

export default Footer;



