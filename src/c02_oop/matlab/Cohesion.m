function Cohesion()
    % Explanation
    % 1. Low Cohesion (UserAccount):
    %    - Die Klasse UserAccount verwaltet sowohl Benutzerdaten als auch die Anzeige von Benutzerinformationen und Freundeslisten.
    %    - Durch die Vermischung von Verantwortlichkeiten wird die Wartung erschwert, da Änderungen an der Datenverwaltung oder der Anzeige
    %      Anpassungen an der gesamten Klasse erfordern.
    % 2. High Cohesion (UserManager und UserPrinter):
    %    - UserManager ist ausschließlich für die Verwaltung der Benutzerdaten verantwortlich.
    %    - UserPrinter ist für die Anzeige der Benutzerinformationen und der Freundesliste zuständig.
    %    - Jede Klasse hat eine einzelne, fokussierte Verantwortung, wodurch sie leichter zu warten und zu erweitern ist.

    % Low Cohesion example
    fprintf('Low Cohesion Example:\n');
    user1 = UserAccount('Alice', 30);
    user1.addFriend('Bob');
    user1.addFriend('Charlie');
    user1.displayUserDetails();
    user1.printFriends();

    fprintf('\nHigh Cohesion Example:\n');
    user2 = UserManager('Alice', 30);
    user2.addFriend('Bob');
    user2.addFriend('Charlie');

    UserPrinter.displayUserDetails(user2);
    UserPrinter.printFriends(user2);
end

% Low Cohesion Example
classdef UserAccount < handle
    properties
        name
        age
        friends = {}
    end
    methods
        function obj = UserAccount(name, age)
            obj.name = name;
            obj.age = age;
        end
        function addFriend(obj, friendName)
            obj.friends{end+1} = friendName;
        end
        function displayUserDetails(obj)
            fprintf('User: %s, Age: %d\n', obj.name, obj.age);
        end
        function printFriends(obj)
            fprintf('Friends of %s:\n', obj.name);
            for i = 1:length(obj.friends)
                fprintf('- %s\n', obj.friends{i});
            end
        end
    end
end

% High Cohesion Example
classdef UserManager < handle
    properties
        name
        age
        friends = {}
    end
    methods
        function obj = UserManager(name, age)
            obj.name = name;
            obj.age = age;
        end
        function addFriend(obj, friendName)
            obj.friends{end+1} = friendName;
        end
    end
end

classdef UserPrinter
    methods (Static)
        function displayUserDetails(user)
            fprintf('User: %s, Age: %d\n', user.name, user.age);
        end
        function printFriends(user)
            fprintf('Friends of %s:\n', user.name);
            for i = 1:length(user.friends)
                fprintf('- %s\n', user.friends{i});
            end
        end
    end
end
