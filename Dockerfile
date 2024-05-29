# Use an official Ruby runtime as a parent image
FROM ruby:2.7

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the main application file
COPY hello.rb .

# Command to run when the container starts
CMD ["ruby", "hello.rb"]
