export class BookingDetails {

  public name :string;
  public code: String;
  public  hashCode: number;
  public img: string;
  public seats_left: number;
  public departure: Date;
  public arrival: Date;
  public price: number;

  constructor(
    name: string,
    code: string,
    hashCode: number,
    img: string,
    seats_left: number,
    departure: Date,
    arrival: Date,
    price: number
  ) {
    this.name = name;
    this.code = code;
    this.hashCode = hashCode;
    this.img = img;
    this.seats_left = seats_left;
    this.departure = departure;
    this.arrival = arrival;
    this.price = price;
  }

}
