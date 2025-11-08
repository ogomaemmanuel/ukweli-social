import Image from "next/image"
export default function MainContent() {
    const articles = [
        {
            id: 1,
            title: "Getting Started with React",
            excerpt: "Learn the basics of React and start building your first app.",
            author: {
                name: "John Doe",
                avatar: "/placeholder.svg?height=40&width=40",
            },
            date: "May 15, 2023",
        },
        {
            id: 2,
            title: "Mastering Tailwind CSS",
            excerpt: "Discover advanced techniques for using Tailwind CSS in your projects.",
            author: {
                name: "Jane Smith",
                avatar: "/placeholder.svg?height=40&width=40",
            },
            date: "May 18, 2023",
        },
        {
            id: 3,
            title: "The Power of Next.js",
            excerpt: "Explore the features that make Next.js a great choice for React applications.",
            author: {
                name: "Bob Johnson",
                avatar: "/placeholder.svg?height=40&width=40",
            },
            date: "May 20, 2023",
        },
    ]

    return (
        <main className="w-full lg:w-1/2">
            <div className="bg-white rounded-lg shadow p-6 mb-8">
        <textarea
            placeholder="What's on your mind?"
            className="w-full p-4 border rounded-lg resize-none focus:outline-none focus:ring-2 focus:ring-blue-500"
            rows={4}
        ></textarea>
                <button className="mt-4 px-4 py-2 bg-blue-500 text-white rounded-md text-sm hover:bg-blue-600 transition-colors">
                    Post
                </button>
            </div>
            <div className="space-y-8">
                {articles.map((article) => (
                    <article key={article.id} className="bg-white rounded-lg shadow p-6">
                        <div className="flex items-center space-x-3 mb-4">
                            <Image
                                src={article.author.avatar || "/placeholder.svg"}
                                alt={`${article.author.name}'s avatar`}
                                width={40}
                                height={40}
                                className="rounded-full"
                            />
                            <div>
                                <p className="font-semibold">{article.author.name}</p>
                                <p className="text-sm text-gray-500">{article.date}</p>
                            </div>
                        </div>
                        <h2 className="text-xl font-bold mb-2">{article.title}</h2>
                        <p className="text-gray-600 mb-4">{article.excerpt}</p>
                        <div className="text-right">
                            <a href="#" className="text-blue-500 hover:underline">
                                Read more
                            </a>
                        </div>
                    </article>
                ))}
            </div>
        </main>
    )
}

