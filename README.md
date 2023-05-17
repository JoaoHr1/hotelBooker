![Logo Hotel Booker](https://user-images.githubusercontent.com/115806935/232183425-3f2bde6d-d918-4979-b29c-88f12aad5860.png)
<h3>Hotel Booker is a project made with java and Spring Boot that help hotels to manage their rooms and guests using Rest API architecture.</h3>

---

<h3> Configuration </h3>

To run Hotel Booker, you need to have the Java Development Kit (JDK) 17.0.6 and PostgreSql installed and configured on your machine.



>**Endpoints & Demonstration**
>
| METHOD | ENDPOINT | DESCRIPTION | CODE |
|-----|:---------------|:---------------|:---------------|
|     GET| /rooms/{id}   |       Find a room by id     | 200 |
|     GET| /rooms/unavailable     |        Find occupied rooms       | 200 |
|     GET| /rooms/available    |        Find empty rooms       | 200    |
|     GET| /guests    |        Find registered guests       | 200    |
|     GET| /guests/{id}   |        Find registered guests by id      | 200   |
|     POST| /rooms    |       Create a new room    | 201 |
|     POST| /guests    |       Create a new guest    | 201    |
|     POST| /login    |       Create a new admin account  | 201     |
|     PUT|  /rooms    |       Change room information | 200  |
|     PUT| /guests    |       Change guest information | 200  |
|     PATCH| /rooms/available/{id}    |       Turn room into available  | 200  |
|     DELETE| /rooms/unavailable/{id}    |       Turn room into unavailable  | 204 |
|     DELETE| /guests/{id}   |       Delete guest from database  | 204 |

>

# Room's body
```json
{
  "name": "Standard room 2",
  "description": "2 confortable beds, tv and a beautiful beach view ",
  "roomType": "STANDARD",
  "pricePerNight": 750.00
}
```

> Summary

<li>id - generated automatically

<li>name - the room name 

<li>description - describe important informations about the room 

<li>roomType - enums that can be "STANDARD", "MASTER" or "DELUXE"

<li>pricePerNight - the cost per night of the room

>

# Guest's body
```json
{
  "name": "John",
  "cpf": "12345678910",
  "checkinDate": "2023-04-15T06:32:09.663Z",
  "checkoutDate": "2023-04-15T06:32:09.663Z",
  "roomId":2
}
```

> Summary
<li>id - generated automatically

<li>name - the guest name

<li>cpf - Cadastro de pessoa fisica (unique) (only 11 characters)

<li>checkinDate - the time you checked in

<li>checkoutDate - the scheduled time for checkout

<li>roomId - the room id that was assigned

<h3>

> Technologies used

</h3>

<li> Java JDK (17.0.6)
<li> Spring Boot (3.0.5)
<li> Maven
<li> PostgreSQL
<li> Flyway
<li> Swagger

<br>
<br>

>
> Thankings
>



```
Thank you for taking the time reading this project. I hope that the information presented 
here was helpful. If you have any feedback or suggestions, please feel free to reach out to me!
```
