FROM oracle/graalvm-ce:19.2.0.1
RUN gu install ruby
WORKDIR /workdir
RUN echo 'puts "Hello from Truffleruby!\nVersion: #{RUBY_DESCRIPTION}"' > app.rb
CMD ruby app.rb