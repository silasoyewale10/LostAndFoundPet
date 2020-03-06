# Debt Eliminator

### A debt tracking application

**The purpose Of this app is to provide users with a way to visually see all of their accumulated and get an estimate of how long they will need to keep paying it off at their current rate**

## User Stories 

- As a user I want to be able to create a login and have a stored user name and password. 

- As a user I want to be able to have multiple inputs for my debts

- As a user I want to be able to add how much I am paying monthly on my debts

- As a user I want to be able to see how long I have remaining on my current debt payments based on what I am currently paying each month

- As a user I want to see my results in a chart form so I can easily understand the information I am looking at



Image of Domain Modeling






Trello Board 

https://trello.com/b/cisCT8Yo/team-win


Wire Frame

https://wireframepro.mockflow.com/view/M1bbd724c2c25f8d5e7f17c27e2537b3e1583519894847#/page/a9f36bb316ea48fba9929b5bf8889173


Schema

type Tasks @model {
  id: ID!
  title: String!
  total: int
  monthly: int
  length: int
}

