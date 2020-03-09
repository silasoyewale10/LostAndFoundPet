# WELCOME TO LOST AND FOUND PET(S)


## Image of Domain Modeling






## TRELLO BOARD

https://trello.com/b/cisCT8Yo/team-win



## WIRE FRAME

https://wireframepro.mockflow.com/view/M1bbd724c2c25f8d5e7f17c27e2537b3e1583519894847#/page/a9f36bb316ea48fba9929b5bf8889173


## Problem Domain

![](https://github.com/silasoyewale10/DebtEliminator/blob/developmentBranch/problemdomain.pdf)


## SCHEMA

```


type Tasks @model {
  id: ID!
  title: String!
  total: int
  monthly: int
  length: int
}

```


**USER STORIES* 

- As a user I want to share a photo of my lost pet
- As a user I want to share a photo of a found pet
- As a  user I want to log into an application
- As a user I want my profile information saved, so I do not have to enter in my information more than once
- As a user I want to be able to upload a photo, “post a picture”, of my lost pet
- As a user I want to be able to view photos of found pets
- As a user I want to be able to select or see potential matches of my lost pet
- As a user I want to be able to notify or contact another user they may have my lost pet


**DEVELOPER STORIES**

- As a developer I want to write an application that allows owners of lost pets and found pets to collectively share information in hopes of reuniting families
- As a developer I want to allow users to safely log-in and store their profile information user AWS Cognitio and an S3 bucket. 
- As a developer I want to use S3 to store photos of lost and missing pets 
- As a developer I want to incorporate google location services for proximity in searches
- As a developer I want to display a collective image view of lost and found pets by proximity 
- As a developer I want the contact information returned when a user selects a possible match
- As a developer I want to use Amazon Rekognition services to match dogs. 



