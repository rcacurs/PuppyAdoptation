package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

const val BIO_PLACEHOLDER = "Lorem Ipsum is simply dummy " +
        "text of the printing and typesetting" +
        "industry. Lorem Ipsum has been the " +
        "industry's standard dummy text ever since" +
        " the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type" +
        " specimen book. It has survived not only five" +
        " centuries, but also the leap into electronic" +
        " typesetting, remaining essentially unchanged." +
        " It was popularised in the 1960s with the release" +
        " of Letraset sheets containing Lorem Ipsum passages" +
        " and more recently with desktop publishing software" +
        " like Aldus PageMaker including versions of Lorem Ipsum."

const val BIO_2 = "Agile, flexible, springy, " +
        "alert and always ready to hunt - a real weasel! \uD83D\uDC15\n" +
        "\n" +
        "The unusual exotic look of " +
        "the Beautiful immediately attracts the eye," +
        " but the graceful movements do not allow this attention to relax." +
        " Greta is in constant motion and challenge. Greta is benevolent towards people and perceives" +
        " them by feeling - as a company for a pleasant time or for a quick game and competition."

class PuppyDB {
    val puppies = mutableListOf<Puppy>()

    init {
        puppies.add(Puppy("Snow", Gender.MALE, bio=BIO_PLACEHOLDER, R.drawable.puppy0))
        puppies.add(Puppy("Barky", Gender.FEMALE, bio=BIO_2, R.drawable.puppy1))
        puppies.add(Puppy("Browny", Gender.MALE, bio=BIO_PLACEHOLDER, R.drawable.puppy2))
        puppies.add(Puppy("Roger", Gender.MALE, bio=BIO_PLACEHOLDER, R.drawable.puppy3))
        puppies.add(Puppy("Rudolf", Gender.MALE, bio=BIO_PLACEHOLDER, R.drawable.puppy4))
        puppies.add(Puppy("Waverly", Gender.FEMALE, bio=BIO_PLACEHOLDER, R.drawable.puppy5))
        puppies.add(Puppy("Fluffy", Gender.FEMALE, bio=BIO_PLACEHOLDER, R.drawable.puppy6))
        puppies.add(Puppy("Jasper", Gender.MALE, bio=BIO_PLACEHOLDER, R.drawable.puppy7))
    }
}