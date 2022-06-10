export class Envoice {

  public user: string ;
  public success: boolean ;
  public name: string;
  public code: String;
  public hashCode: number;
  public img: string;
  public departure: Date;
  public arrival: Date;
  public price: number;

  constructor(
    user: string ,
    success: boolean,
    name: string,
    code: string,
    hashCode: number,
    img: string,
    departure: Date,
    arrival: Date,
    price: number
  ) {
    this.name = name;
    this.code = code;
    this.hashCode = hashCode;
    this.img = img;
    this.user = user;
    this.success = success;
    this.departure = departure;
    this.arrival = arrival;
    this.price = price;
  }

}
