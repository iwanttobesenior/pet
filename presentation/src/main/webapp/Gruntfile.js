module.exports = function(grunt) {
    grunt.initConfig({
        uglify : {
            my_target : {
                files : {
                    'dest/app.min.js' : [ 'javascript/app.js', 'javascript/controllers.js' ]
                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.registerTask('default', [ 'uglify' ]);
};